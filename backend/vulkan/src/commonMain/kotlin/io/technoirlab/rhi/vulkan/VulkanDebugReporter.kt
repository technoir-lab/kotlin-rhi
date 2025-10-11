package io.technoirlab.rhi.vulkan

import io.github.oshai.kotlinlogging.KLogger
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_SEVERITY_ERROR_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_SEVERITY_INFO_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_SEVERITY_VERBOSE_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_SEVERITY_WARNING_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_TYPE_GENERAL_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_TYPE_PERFORMANCE_BIT_EXT
import io.technoirlab.volk.VK_DEBUG_UTILS_MESSAGE_TYPE_VALIDATION_BIT_EXT
import io.technoirlab.volk.VkDebugUtilsMessengerCallbackDataEXT
import io.technoirlab.vulkan.Instance
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString

internal class VulkanDebugReporter(instance: Instance, logger: KLogger) : AutoCloseable {
    private val loggerRef = StableRef.create(logger)
    private val messenger = memScoped {
        instance.createDebugUtilsMessenger {
            messageSeverity = VK_DEBUG_UTILS_MESSAGE_SEVERITY_ERROR_BIT_EXT or
                VK_DEBUG_UTILS_MESSAGE_SEVERITY_WARNING_BIT_EXT or
                VK_DEBUG_UTILS_MESSAGE_SEVERITY_INFO_BIT_EXT
            messageType = VK_DEBUG_UTILS_MESSAGE_TYPE_GENERAL_BIT_EXT or
                VK_DEBUG_UTILS_MESSAGE_TYPE_VALIDATION_BIT_EXT or
                VK_DEBUG_UTILS_MESSAGE_TYPE_PERFORMANCE_BIT_EXT
            pfnUserCallback = staticCFunction(::debugUtilsCallbackFun)
            pUserData = loggerRef.asCPointer()
        }
    }

    override fun close() {
        messenger.close()
        loggerRef.dispose()
    }
}

@Suppress("ReturnCount", "unused")
private fun debugUtilsCallbackFun(
    messageSeverity: UInt,
    messageTypes: UInt,
    callbackData: CPointer<VkDebugUtilsMessengerCallbackDataEXT>?,
    userData: COpaquePointer?
): UInt {
    val message = callbackData?.pointed?.pMessage?.toKString() ?: return 0u
    val logger = userData?.asStableRef<KLogger>()?.get() ?: return 0u

    when {
        messageSeverity and VK_DEBUG_UTILS_MESSAGE_SEVERITY_ERROR_BIT_EXT != 0u -> logger.error { message }
        messageSeverity and VK_DEBUG_UTILS_MESSAGE_SEVERITY_WARNING_BIT_EXT != 0u -> logger.warn { message }
        messageSeverity and VK_DEBUG_UTILS_MESSAGE_SEVERITY_INFO_BIT_EXT != 0u -> logger.info { message }
        messageSeverity and VK_DEBUG_UTILS_MESSAGE_SEVERITY_VERBOSE_BIT_EXT != 0u -> logger.debug { message }
    }
    return 0u
}

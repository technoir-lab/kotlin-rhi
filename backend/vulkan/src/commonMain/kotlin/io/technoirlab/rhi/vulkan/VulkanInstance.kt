package io.technoirlab.rhi.vulkan

import io.github.oshai.kotlinlogging.KotlinLogging
import io.technoirlab.rhi.core.WindowHandle
import io.technoirlab.volk.VK_EXT_DEBUG_UTILS_EXTENSION_NAME
import io.technoirlab.volk.VK_INSTANCE_CREATE_ENUMERATE_PORTABILITY_BIT_KHR
import io.technoirlab.volk.VK_KHR_PORTABILITY_ENUMERATION_EXTENSION_NAME
import io.technoirlab.volk.VK_MAKE_VERSION
import io.technoirlab.vulkan.Instance
import io.technoirlab.vulkan.Surface
import io.technoirlab.vulkan.Vulkan
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toCStringArray

internal class VulkanInstance(
    private val vulkan: Vulkan,
    private val apiVersion: UInt,
    private val enabledLayers: Set<VulkanLayer>,
    private val enabledExtensions: Set<VulkanExtension>
) : AutoCloseable {

    private val logger = KotlinLogging.logger("VulkanRenderer")
    private val instance = memScoped { vulkan.createInstance(enabledLayers, enabledExtensions) }
    private val debugReporter: VulkanDebugReporter?

    init {
        logger.info { "Created Vulkan instance. API version ${versionToString(apiVersion)}" }

        if (enabledLayers.isNotEmpty()) {
            logger.info { "Enabled instance layers: [${enabledLayers.joinToString()}]" }
        }
        if (enabledExtensions.isNotEmpty()) {
            logger.info { "Enabled instance extensions: [${enabledExtensions.joinToString()}]" }
        }

        debugReporter = if (enabledExtensions.any { it.name == VK_EXT_DEBUG_UTILS_EXTENSION_NAME }) {
            VulkanDebugReporter(instance, logger)
        } else {
            null
        }
    }

    override fun close() {
        debugReporter?.close()
        instance.close()
    }

    context(memScope: MemScope)
    fun createSurface(windowHandle: WindowHandle): Surface =
        instance.createSurface(windowHandle)

    context(memScope: MemScope)
    fun getPhysicalDevices(): List<VulkanPhysicalDevice> =
        instance.enumeratePhysicalDevices().map { VulkanPhysicalDevice(it) }.toList()

    context(memScope: MemScope)
    private fun Vulkan.createInstance(enabledLayers: Collection<VulkanLayer>, enabledExtensions: Collection<VulkanExtension>): Instance {
        val layerNames = enabledLayers.map { it.name }.toCStringArray(memScope)
        val extensionNames = enabledExtensions.map { it.name }.toCStringArray(memScope)
        return createInstance(
            applicationInfo = {
                applicationVersion = VK_MAKE_VERSION(1u, 0u, 0u)
                engineVersion = VK_MAKE_VERSION(1u, 0u, 0u)
                apiVersion = this@VulkanInstance.apiVersion
            },
            instanceInfo = {
                flags = if (VulkanExtension(VK_KHR_PORTABILITY_ENUMERATION_EXTENSION_NAME) in enabledExtensions) {
                    VK_INSTANCE_CREATE_ENUMERATE_PORTABILITY_BIT_KHR
                } else {
                    0u
                }
                enabledLayerCount = enabledLayers.size.toUInt()
                ppEnabledLayerNames = layerNames
                enabledExtensionCount = enabledExtensions.size.toUInt()
                ppEnabledExtensionNames = extensionNames
            }
        )
    }
}

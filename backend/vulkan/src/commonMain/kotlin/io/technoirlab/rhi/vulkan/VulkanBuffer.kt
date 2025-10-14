package io.technoirlab.rhi.vulkan

import io.technoirlab.rhi.core.Buffer
import kotlinx.cinterop.memScoped
import kotlinx.io.Source
import io.technoirlab.vulkan.Buffer as VkBuffer
import io.technoirlab.vulkan.DeviceMemory as VkDeviceMemory

internal abstract class VulkanBuffer(
    internal val buffer: VkBuffer,
    private val memory: VkDeviceMemory,
    override val size: UInt
) : Buffer {

    override fun updateData(source: Source, size: UInt, offset: UInt) = memScoped {
        memory.copyData(source, size.toULong(), offset.toULong())
    }

    override fun close() {
        memory.close()
        buffer.close()
    }
}

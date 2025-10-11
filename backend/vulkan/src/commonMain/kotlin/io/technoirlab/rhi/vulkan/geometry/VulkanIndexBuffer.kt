package io.technoirlab.rhi.vulkan.geometry

import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.IndexType
import io.technoirlab.vulkan.Buffer
import io.technoirlab.vulkan.DeviceMemory

internal class VulkanIndexBuffer(
    val buffer: Buffer,
    private val memory: DeviceMemory,
    override val size: UInt,
    override val indexType: IndexType
) : IndexBuffer {

    override fun close() {
        memory.close()
        buffer.close()
    }
}

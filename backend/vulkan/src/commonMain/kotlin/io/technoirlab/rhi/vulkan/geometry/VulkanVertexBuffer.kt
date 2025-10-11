package io.technoirlab.rhi.vulkan.geometry

import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.rhi.core.geometry.VertexLayout
import io.technoirlab.vulkan.Buffer
import io.technoirlab.vulkan.DeviceMemory

internal class VulkanVertexBuffer(
    val buffer: Buffer,
    private val memory: DeviceMemory,
    override val size: UInt,
    override val vertexLayout: VertexLayout
) : VertexBuffer {

    override fun close() {
        memory.close()
        buffer.close()
    }
}

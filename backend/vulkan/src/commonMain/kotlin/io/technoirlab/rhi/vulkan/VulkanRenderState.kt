package io.technoirlab.rhi.vulkan

import io.technoirlab.rhi.core.RenderState
import io.technoirlab.rhi.core.Shader
import io.technoirlab.rhi.core.geometry.IndexBuffer
import io.technoirlab.rhi.core.geometry.PrimitiveType
import io.technoirlab.rhi.core.geometry.VertexBuffer
import io.technoirlab.vulkan.Pipeline
import io.technoirlab.vulkan.PipelineCache
import io.technoirlab.vulkan.PipelineLayout

@Suppress("LongParameterList")
internal class VulkanRenderState(
    val pipeline: Pipeline,
    val pipelineLayout: PipelineLayout,
    val pipelineCache: PipelineCache,
    override val vertexBuffer: VertexBuffer,
    override val indexBuffer: IndexBuffer,
    override val primitiveType: PrimitiveType,
    override val vertexShader: Shader,
    override val fragmentShader: Shader,
    override var pushConstants: ByteArray? = null
) : RenderState {

    override fun close() {
        pipeline.close()
        pipelineCache.close()
        pipelineLayout.close()
    }
}

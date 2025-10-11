package io.technoirlab.rhi.vulkan

import io.technoirlab.rhi.core.Shader
import io.technoirlab.vulkan.ShaderModule

internal class VulkanShader(
    val shader: ShaderModule
) : Shader {

    override fun close() {
        shader.close()
    }
}

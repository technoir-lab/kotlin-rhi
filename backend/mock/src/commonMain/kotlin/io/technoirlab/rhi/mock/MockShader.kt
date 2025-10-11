package io.technoirlab.rhi.mock

import io.technoirlab.rhi.core.Shader

internal class MockShader: Shader {
    override fun close() = Unit
}

package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.webgpu.WebGpuRenderer

actual fun createRenderer(): Renderer = WebGpuRenderer()

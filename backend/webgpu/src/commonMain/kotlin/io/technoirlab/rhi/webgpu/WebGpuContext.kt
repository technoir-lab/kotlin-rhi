package io.technoirlab.rhi.webgpu

import io.technoirlab.rhi.core.WindowHandle
import io.ygdrasil.webgpu.WGPUContext

internal expect suspend fun createWebGpuContext(window: WindowHandle): WGPUContext

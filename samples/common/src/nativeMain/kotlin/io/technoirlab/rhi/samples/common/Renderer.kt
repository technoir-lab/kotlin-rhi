package io.technoirlab.rhi.samples.common

import io.technoirlab.rhi.core.Renderer
import io.technoirlab.rhi.vulkan.VulkanRenderer

actual fun createRenderer(): Renderer = VulkanRenderer()

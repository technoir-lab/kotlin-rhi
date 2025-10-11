package io.technoirlab.rhi.vulkan

import io.technoirlab.rhi.core.FrameState
import io.technoirlab.vulkan.CommandBuffer
import io.technoirlab.vulkan.Fence
import io.technoirlab.vulkan.Semaphore

@Suppress("LongParameterList")
internal class VulkanFrameState(
    val imageIndex: UInt,
    val image: VulkanImage2D,
    val depthStencil: VulkanImage2D?,
    val commandBuffer: CommandBuffer,
    val acquireSemaphore: Semaphore,
    val submitSemaphore: Semaphore,
    val submitFence: Fence,
    val recreate: Boolean
) : FrameState

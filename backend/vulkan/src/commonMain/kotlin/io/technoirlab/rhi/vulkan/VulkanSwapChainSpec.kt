package io.technoirlab.rhi.vulkan

import dev.romainguy.kotlin.math.Float4
import io.technoirlab.rhi.core.ClearValues
import io.technoirlab.rhi.core.Format
import io.technoirlab.volk.VkColorSpaceKHR
import io.technoirlab.volk.VkPresentModeKHR
import io.technoirlab.volk.VkSurfaceTransformFlagBitsKHR

internal data class VulkanSwapChainSpec(
    val imageCount: UInt,
    val imageFormat: Format,
    val imageColorSpace: VkColorSpaceKHR,
    val presentMode: VkPresentModeKHR,
    val transform: VkSurfaceTransformFlagBitsKHR,
    val depthStencilFormat: Format?,
    @Suppress("MagicNumber")
    val clearValues: ClearValues = ClearValues(
        color = listOf(Float4(0.392f, 0.584f, 0.929f, 1.0f))
    )
) {
    override fun toString(): String =
        "VulkanSwapChainSpec(imageCount=$imageCount, imageFormat=$imageFormat, " +
            "imageColorSpace=${vkColorSpaceToString(imageColorSpace)}, presentMode=${vkPresentModeToString(presentMode)}, " +
            "transform=${vkSurfaceTransformFlagBitsToString(transform)}, depthStencilFormat=$depthStencilFormat}, clearValues=$clearValues)"
}

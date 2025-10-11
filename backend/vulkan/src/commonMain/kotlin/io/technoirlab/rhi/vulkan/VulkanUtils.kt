@file:Suppress("NOTHING_TO_INLINE")

package io.technoirlab.rhi.vulkan

import io.technoirlab.rhi.core.CullMode
import io.technoirlab.rhi.core.FillMode
import io.technoirlab.rhi.core.FrontFace
import io.technoirlab.rhi.core.geometry.IndexType
import io.technoirlab.rhi.core.geometry.PrimitiveType
import io.technoirlab.rhi.core.geometry.VertexAttribute
import io.technoirlab.volk.VK_CULL_MODE_BACK_BIT
import io.technoirlab.volk.VK_CULL_MODE_FRONT_BIT
import io.technoirlab.volk.VK_CULL_MODE_NONE
import io.technoirlab.volk.VK_FORMAT_R32G32B32A32_SFLOAT
import io.technoirlab.volk.VK_FORMAT_R32G32B32_SFLOAT
import io.technoirlab.volk.VK_FORMAT_R32G32_SFLOAT
import io.technoirlab.volk.VK_FORMAT_R32_SFLOAT
import io.technoirlab.volk.VK_FRONT_FACE_CLOCKWISE
import io.technoirlab.volk.VK_FRONT_FACE_COUNTER_CLOCKWISE
import io.technoirlab.volk.VK_INDEX_TYPE_UINT16
import io.technoirlab.volk.VK_INDEX_TYPE_UINT32
import io.technoirlab.volk.VK_INDEX_TYPE_UINT8
import io.technoirlab.volk.VK_POLYGON_MODE_FILL
import io.technoirlab.volk.VK_POLYGON_MODE_LINE
import io.technoirlab.volk.VK_PRIMITIVE_TOPOLOGY_LINE_LIST
import io.technoirlab.volk.VK_PRIMITIVE_TOPOLOGY_LINE_STRIP
import io.technoirlab.volk.VK_PRIMITIVE_TOPOLOGY_POINT_LIST
import io.technoirlab.volk.VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST
import io.technoirlab.volk.VK_PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP
import io.technoirlab.volk.VK_VERSION_MAJOR
import io.technoirlab.volk.VK_VERSION_MINOR
import io.technoirlab.volk.VK_VERSION_PATCH
import io.technoirlab.volk.VkColorSpaceKHR
import io.technoirlab.volk.VkCullModeFlags
import io.technoirlab.volk.VkExtent2D
import io.technoirlab.volk.VkFormat
import io.technoirlab.volk.VkFrontFace
import io.technoirlab.volk.VkIndexType
import io.technoirlab.volk.VkPolygonMode
import io.technoirlab.volk.VkPresentModeKHR
import io.technoirlab.volk.VkPrimitiveTopology
import io.technoirlab.volk.VkSurfaceTransformFlagBitsKHR
import io.technoirlab.volk.string_VkColorSpaceKHR
import io.technoirlab.volk.string_VkPresentModeKHR
import io.technoirlab.volk.string_VkSurfaceTransformFlagBitsKHR
import kotlinx.cinterop.toKString

internal inline fun vkPresentModeToString(presentMode: VkPresentModeKHR): String =
    string_VkPresentModeKHR(presentMode)!!.toKString().removePrefix("VK_PRESENT_MODE_")

internal inline fun vkColorSpaceToString(colorSpace: VkColorSpaceKHR): String =
    string_VkColorSpaceKHR(colorSpace)!!.toKString().removePrefix("VK_COLOR_SPACE_")

internal inline fun vkSurfaceTransformFlagBitsToString(transform: VkSurfaceTransformFlagBitsKHR): String =
    string_VkSurfaceTransformFlagBitsKHR(transform)!!.toKString().removePrefix("VK_SURFACE_TRANSFORM_")

internal inline fun VkExtent2D.asString(): String = "${width}x$height"

internal inline fun versionToString(version: UInt): String =
    "${VK_VERSION_MAJOR(version)}.${VK_VERSION_MINOR(version)}.${VK_VERSION_PATCH(version)}"

internal fun CullMode.toVkCullMode(): VkCullModeFlags = when (this) {
    CullMode.Back -> VK_CULL_MODE_BACK_BIT
    CullMode.Front -> VK_CULL_MODE_FRONT_BIT
    CullMode.None -> VK_CULL_MODE_NONE
}

internal fun FillMode.toVkPolygonMode(): VkPolygonMode = when (this) {
    FillMode.Solid -> VK_POLYGON_MODE_FILL
    FillMode.Wireframe -> VK_POLYGON_MODE_LINE
}

internal fun FrontFace.toVkFrontFace(): VkFrontFace = when (this) {
    FrontFace.CounterClockwise -> VK_FRONT_FACE_COUNTER_CLOCKWISE
    FrontFace.Clockwise -> VK_FRONT_FACE_CLOCKWISE
}

internal fun IndexType.toVkIndexType(): VkIndexType =
    when (this) {
        IndexType.Int8 -> VK_INDEX_TYPE_UINT8
        IndexType.Int16 -> VK_INDEX_TYPE_UINT16
        IndexType.Int32 -> VK_INDEX_TYPE_UINT32
    }

internal fun PrimitiveType.toVkPrimitiveTopology(): VkPrimitiveTopology =
    when (this) {
        PrimitiveType.PointList -> VK_PRIMITIVE_TOPOLOGY_POINT_LIST
        PrimitiveType.LineList -> VK_PRIMITIVE_TOPOLOGY_LINE_LIST
        PrimitiveType.LineStrip -> VK_PRIMITIVE_TOPOLOGY_LINE_STRIP
        PrimitiveType.TriangleList -> VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST
        PrimitiveType.TriangleStrip -> VK_PRIMITIVE_TOPOLOGY_TRIANGLE_STRIP
    }

internal fun VertexAttribute.Type.toVkFormat(): VkFormat =
    when (this) {
        VertexAttribute.Type.Float -> VK_FORMAT_R32_SFLOAT
        VertexAttribute.Type.Float2 -> VK_FORMAT_R32G32_SFLOAT
        VertexAttribute.Type.Float3 -> VK_FORMAT_R32G32B32_SFLOAT
        VertexAttribute.Type.Float4 -> VK_FORMAT_R32G32B32A32_SFLOAT
    }

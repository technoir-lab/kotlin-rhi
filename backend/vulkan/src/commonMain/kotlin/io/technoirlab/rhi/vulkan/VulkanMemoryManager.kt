package io.technoirlab.rhi.vulkan

import io.technoirlab.volk.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT
import io.technoirlab.volk.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
import io.technoirlab.volk.VkMemoryPropertyFlags
import io.technoirlab.volk.VkPhysicalDeviceMemoryProperties
import io.technoirlab.vulkan.Buffer
import io.technoirlab.vulkan.Device
import io.technoirlab.vulkan.DeviceMemory
import io.technoirlab.vulkan.Image
import io.technoirlab.vulkan.PhysicalDevice
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.get

internal class VulkanMemoryManager(
    private val device: Device,
    private val physicalDevice: PhysicalDevice
) {
    context(memScope: MemScope)
    fun allocateBufferMemory(buffer: Buffer, flags: VkMemoryPropertyFlags = VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT): DeviceMemory {
        val deviceMemoryProperties = physicalDevice.getMemoryProperties()
        val memoryRequirements = buffer.getMemoryRequirements()
        val memory = device.allocateMemory {
            allocationSize = memoryRequirements.size
            memoryTypeIndex = findMemoryType(deviceMemoryProperties, memoryRequirements.memoryTypeBits, flags)
        }
        buffer.bindMemory(memory)
        return memory
    }

    context(memScope: MemScope)
    fun allocateImageMemory(image: Image, flags: VkMemoryPropertyFlags = VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT): DeviceMemory {
        val deviceMemoryProperties = physicalDevice.getMemoryProperties()
        val memoryRequirements = image.getMemoryRequirements()
        val memory = device.allocateMemory {
            allocationSize = memoryRequirements.size
            memoryTypeIndex = findMemoryType(deviceMemoryProperties, memoryRequirements.memoryTypeBits, flags)
        }
        image.bindMemory(memory)
        return memory
    }

    private fun findMemoryType(
        memoryProperties: VkPhysicalDeviceMemoryProperties,
        memoryTypeBits: UInt,
        flags: VkMemoryPropertyFlags
    ): UInt {
        var index = UInt.MAX_VALUE
        for (i in 0u..<memoryProperties.memoryTypeCount) {
            if ((memoryTypeBits and (1u shl i.toInt())) != 0u &&
                (memoryProperties.memoryTypes[i.toInt()].propertyFlags and flags) == flags
            ) {
                index = i
                break
            }
        }
        check(index != UInt.MAX_VALUE) { "Unable to find suitable memory type" }
        return index
    }
}

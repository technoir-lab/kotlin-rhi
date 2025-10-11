package io.technoirlab.rhi.vulkan

import kotlinx.cinterop.CArrayPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.NativePlacement
import kotlinx.cinterop.UIntVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.set

@ExperimentalForeignApi
internal fun NativePlacement.allocArrayOf(elements: List<UInt>): CArrayPointer<UIntVar> {
    val array = allocArray<UIntVar>(elements.size)
    var index = 0
    while (index < elements.size) {
        array[index] = elements[index]
        ++index
    }
    return array
}

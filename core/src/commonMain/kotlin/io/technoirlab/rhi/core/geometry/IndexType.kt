package io.technoirlab.rhi.core.geometry

enum class IndexType {
    Int8,
    Int16,
    Int32
}

val IndexType.sizeInBytes: UInt
    get() = when (this) {
        IndexType.Int8 -> 1u
        IndexType.Int16 -> 2u
        IndexType.Int32 -> 4u
    }

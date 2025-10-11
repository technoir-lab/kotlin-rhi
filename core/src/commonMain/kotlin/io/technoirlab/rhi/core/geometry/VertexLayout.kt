package io.technoirlab.rhi.core.geometry

data class VertexLayout(
    val attributes: List<VertexAttribute>,
    val vertexSize: UInt
) {
    companion object {
        fun packed(vararg attributes: VertexAttribute): VertexLayout =
            VertexLayout(attributes.toList(), attributes.sumOf { it.type.sizeInBytes.toInt() }.toUInt())
    }
}

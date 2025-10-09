plugins {
    id("io.technoirlab.conventions.root")
}

dependencies {
    nmcpAggregation(project(":core"))
    nmcpAggregation(project(":backend:mock"))
    nmcpAggregation(project(":backend:vulkan"))
}

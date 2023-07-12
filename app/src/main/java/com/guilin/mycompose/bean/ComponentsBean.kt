package com.guilin.mycompose.bean

data class ComponentsBean(val name: String, val children: List<ComponentsChild>)
data class ComponentsChild(val name: String)
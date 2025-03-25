package com.custommon

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class TypeLateInitializer {
    @PostConstruct
    fun initializeWeaknesses() {
        Type.initializeWeaknesses()
    }
}
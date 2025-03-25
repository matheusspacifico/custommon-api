package com.custommon

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustommonRepository : JpaRepository<Custommon, Int> {
}
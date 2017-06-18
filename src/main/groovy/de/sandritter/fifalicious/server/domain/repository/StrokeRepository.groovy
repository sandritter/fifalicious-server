package de.sandritter.fifalicious.server.domain.repository

import de.sandritter.fifalicious.server.domain.model.Stroke
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StrokeRepository extends CrudRepository<Stroke, Long> {
}

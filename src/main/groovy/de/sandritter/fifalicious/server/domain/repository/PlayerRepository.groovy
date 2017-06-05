package de.sandritter.fifalicious.server.domain.repository

import de.sandritter.fifalicious.server.domain.model.Player
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository extends CrudRepository<Player, Long> {
}

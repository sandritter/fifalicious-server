package de.sandritter.fifalicious.server.domain.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'stroke')
class Stroke {

    @Id
    @Column(name = 'stroke_id')
    Long strokeId

    @Column(name = 'create_date')
    Date createDate

    @Column(name = 'is_active')
    boolean isActive

    @Column(name = 'player_reference')
    long playerId
}

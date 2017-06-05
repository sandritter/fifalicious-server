package de.sandritter.fifalicious.server.domain.model

import javax.persistence.*

@Entity
@Table(name = 'player')
class Player {

    @Id
    @Column(name = 'player_id')
    BigInteger playerId

    @Column(name = 'first_name')
    String firstName

    @Column(name = 'last_name')
    String lastName

    @Column(name = 'last_update')
    String last_update

    @OneToMany(targetEntity = Stroke, fetch = FetchType.EAGER)
    @JoinColumn(name="player_reference")
    List<Stroke> strokes
}

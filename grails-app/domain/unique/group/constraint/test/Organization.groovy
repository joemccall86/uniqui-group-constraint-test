package unique.group.constraint.test

class Organization {

    String name

    static hasMany = [
            channels: Channel
    ]

    static constraints = {
    }
}

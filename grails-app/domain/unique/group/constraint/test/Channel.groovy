package unique.group.constraint.test

class Channel {

    String value
    String name

    static belongsTo = [organization: Organization]

    static constraints = {
        name unique: 'organization'
    }
}

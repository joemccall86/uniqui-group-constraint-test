package unique.group.constraint.test

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class ChannelUniqueSpec extends Specification {

    def 'unique constraint is checked properly, only child class in finder'() {
        when: 'an existing channel has its name changed'
        def channel = Channel.findByName('BarChannel')
        channel.name = 'FooChannel'

        then:
        !channel.validate()
        channel.hasErrors()
        channel.errors.getFieldError('name').code == 'unique'
    }

    def 'unique constraint is checked properly, both classes in finder'() {
        when: 'an existing channel has its name changed'
        def channel = Channel.findByNameAndOrganization('BarChannel', Organization.findByName('Alpha Org'))
        channel.name = 'FooChannel'

        then:
        !channel.validate()
        channel.hasErrors()
        channel.errors.getFieldError('name').code == 'unique'
    }
}

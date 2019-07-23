package unique.group.constraint.test

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        setupData()
    }

    def destroy = {
    }

    @Transactional
    void setupData() {
        def organization = new Organization(name: 'Alpha Org').save()
        assert organization

        organization.addToChannels(new Channel(name: 'FooChannel', value: 'foo'))
        organization.addToChannels(new Channel(name: 'BarChannel', value: 'bar'))
        assert organization.save()
    }
}

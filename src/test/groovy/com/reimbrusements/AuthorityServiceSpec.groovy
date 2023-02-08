package com.reimbrusements

import com.reimbursements.models.User
import com.reimbursements.reporitories.AuthorityRepository
import com.reimbursements.requests.CreateAuthorityRequest
import com.reimbursements.services.AuthorityService
import com.reimbursements.services.UserService
import spock.lang.Specification

class AuthorityServiceSpec extends Specification {

    private static final String AUTHORITY = "admin"
    private static final int USR_ID = 1

    AuthorityRepository repoMock = Mock()
    UserService userSrv = Mock()
    def tested = new AuthorityService(repoMock)

    def "Should save the authority"() {
        setup:
        // TODO: Create a constructor that accepts all dependencies:
        tested.userService = userSrv
        given:
        def authority = createValidAuthority()
        when:
        tested.setNewAuthority(authority)
        then:
        1 * userSrv.getByUserId(USR_ID) >> new User(userID: USR_ID)
        1 * repoMock.save({
            it.authorityName == AUTHORITY
            it.user.userID == USR_ID
        })
    }

    def createValidAuthority() {
        def auth = new CreateAuthorityRequest()
        auth.authorityName = AUTHORITY
        auth.userAuthID = USR_ID
        auth
    }
}

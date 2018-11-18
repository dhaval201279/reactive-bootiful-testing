import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("Should return all reservations")

    request {
        method(GET())
        url("/reservations")
    }

    response {
        status(200)
        headers {
            contentType(applicationJsonUtf8())
        }
        body("""
            [
                { "id" : "1", "reservationName" : "Shruti" }
            ]
        """)
    }
}
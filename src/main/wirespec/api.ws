type CartId = String(/^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$/)
type ProductId = String(/^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$/)

type ProcessPayment {
  amountPaid: Number
}

endpoint ProcessPayment POST ProcessPayment /carts/{cartId: String}/process-payment -> {
    200 -> CartId
}

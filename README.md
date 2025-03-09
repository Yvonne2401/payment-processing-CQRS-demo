CQRS demo payment processing

This service is part of a CQRS demo and exposes an api for a third party payment provider to confirm payments.
These payment confirmations contain a cartId so they can be linked to a certain Cart. When the api is invoked a command is send to the cart-command-model to update the Cart.

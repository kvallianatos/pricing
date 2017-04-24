# pricing

Assumptions:
- Only one offer can be applied to each physical item
- Each item type only has one active offer at any given time
- There is no requirement to maintain the strict item scan order
- Currency is implied and not explicitly handled for simplicity
- Weight units are also implied and not flexibly handled for simplicity
- Item identifiers are string names instead of internal UIDs for simplicity
- Item prices are provided via another service which has already been invoked when populating the shopping cart
- The service providing active offers would be external (different module or microservice) but is modelled as an internal mock service here for simplicity

An alternative implementation would involve using an external service to
populate each item with its current active offer. Then the items could be
grouped by offer type and processed. This would potentially make it easier
to handle offers which involve more than one item type (e.g. buy 3 items of
X brand, get the cheapest one free) however it would involve making each
offer combination concrete ("buy 3 for £7" would be a separate offer type
from "buy 3 for £10").

The current implementation would not immediately
be able to handle offers of type "buy 3 of X brand get the cheapest one free"
but the Item class hierarchy could be extended to include a brand or category
field for this.

Using a ReST API, both the active offers and the current price of any item type
could be defined using the folling URI pattern:

\<base URL\>/price/\<item type\>/current

\<base URL\>/offer/\<item type\>/active
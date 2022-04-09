# Robot-Apocalypse

Requirements
You will develop a REST API (yes, we care about architecture design even in the midst of a zombie apocalypse!), which will store information about the survivors, as well as the resources they own.

In order to accomplish this, the API must fulfill the following use cases:

Add survivors to the database

A survivor must have a name, age, gender and last location (latitude, longitude).

A survivor also has an inventory of resources of their own property (which you need to declare when upon the registration of the survivor).

Update survivor location

A survivor must have the ability to update their last location, storing the new latitude/longitude pair in the base (no need to track locations, just replacing the previous one is enough).

Flag survivor as infected

In a chaotic situation like that, it's inevitable that a survivor may get contaminated by the virus. When this happens, we need to flag the survivor as infected.

A survivor is marked as infected when at least three other survivors report their contamination.

When a survivor is infected, their inventory items become inaccessible (they cannot trade with others).

Reports

The API must offer the following reports:

Percentage of infected survivors.
Percentage of non-infected survivors.
Average amount of each kind of resource by survivor (e.g. 5 waters per survivor)
Points lost because of infected survivor.
Notes
Please use one of the following languages/frameworks: PHP (Laravel), Javascript (Node + Express) or Java (Spring, Seam) - listed in descending order of desirability. It's also possible to implement a solution using Ruby (Rails) or Elixir (Phoenix), but if you want to do so, please notify us in advance.
No authentication is needed (it's a zombie apocalypse, no one will try to hack a system while running from a horde of zombies);
We still care about proper programming and architecture techniques, you must showcase that you're worthy of surving the zombie apocalypse through the sheer strength of your skills;
Don't forget to make at least a minimal documentation of the API endpoints and how to use them;
You must write at least some automated tests;
From the problem description above you can either do a very bare bones solution or add optional features that are not described. Use your time wisely; the absolute optimal solution might take too long to be effective in the apocalypse, so you must come up with the best possible solution that will hold up within the least ammount of time and still be able to showcase your skills in order to prove your worth.
Write concise and clear commit messages, splitting your changes in little pieces.

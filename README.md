## Problem Description

ROBOT apocalypse. The world as we know it has fallen into an apocalyptic scenario. A laboratory-made virus is transforming human beings and animals into zombies, hungry for fresh flesh.

You, as a zombie resistance member (and the last survivor who knows how to code), was designated to develop a system to share resources between non-infected humans.

## Requirements

You will develop a ***REST API*** (yes, we care about architecture design even in the midst of a zombie apocalypse!), which will store information about the survivors, as well as the resources they own.

In order to accomplish this, the API must fulfill the following use cases:

- **Add survivors to the database**

  A survivor must have a *name*, *age*, *gender* and *last location (latitude, longitude)*.

  A survivor also has an inventory of resources of their own property (which you need to declare when upon the registration of the survivor).

- **Update survivor location**

  A survivor must have the ability to update their last location, storing the new latitude/longitude pair in the base (no need to track locations, just replacing the previous one is enough).

- **Flag survivor as infected**

  In a chaotic situation like this, it's inevitable that a survivor may get transformed into a zombie. When this happens, we need to flag the survivor as infected.

  **A survivor is marked as infected when at least three other survivors report their contamination.**

- **Reports**

  The API must also provide the following information:

    1. Percentage of infected survivors.
    2. Percentage of non-infected survivors.
    3. List of infected survivors
    4. List of non-infected survivors
    5. List of robots

---------------------------------------

## Notes

1. No authentication is needed.
2. We still care about proper programming and architecture techniques, you must showcase that you're worthy of surving the zombie apocalypse through the sheer strength of your skills;
3. Don't forget to make at least a minimal documentation of the API endpoints and how to use them;
4. From the problem description above you can either do a very bare bones solution or add optional features that are not described
5. Once done, please check this into a GitHub repo. Please ensure that you have a comprehensive readme that details how to run the application.


---------------------------------------
# Solution
In order to accomplish this challenge, I decided to use Spring boot + Rest Api option. 

# How to get started
After cloning the repository, you should type  

> mvn clean install

so all the dependencies of the project will be installed. 
  
API endpoints documention:

| TYPE         | Endpoint | Result |
|--------------|----------|----------| 
| GET      | /api/survivors/ | Return all survivors |
| GET      | /api/survivors/{id} | Return survivors of id |
| POST       | /api/survivors/register | Creates a new survivor |
| PUT | /api/survivors/{id} | Updates a survivor's location |
| PUT | /api/survivors/{id}/reportInfection/{id2}  | The second survivor reports the first one as infected |
| GET | /survivors/reports | Reports the percentage of infected, percentage of non infected, list of infected, list of non infected survivors and List of Robot |


Example of a request to create a survivor:
```
{
    "name": "Kayyum",
    "age": 27,
    "gender": "Male",
    "location": {
      "latitude": 293.21,
      "longitude": 2132.31
    },
    "resources": {
      "water": 1,
      "ammunition": 2,
      "medication": 3,
      "food": 5
    }
}

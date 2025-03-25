# Custommon API

A Pokémon-inspired API for managing custom creatures (Custommons) in a Spring Boot and Kotlin backend.

## Project Overview

The Custommon API is a RESTful web service that allows users to create, retrieve, and manage custom Pokémon-like creatures.

### Features
- CRUD operations for Custommons
- Automatic weakness calculation based on type
- H2 in-memory database for easy setup
- Uses Spring Boot, JPA, and Kotlin

## Installation & Setup

### Clone the repository
```sh
git clone https://github.com/your-username/custommon-api.git
cd custommon-api
```

### Configure Database (H2 In-Memory)
This API uses H2, an in-memory database, which requires no additional setup.

Check `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:custommondb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

### Run the application
Since it's barebones for now, the best way to run it is to run the main function at CustommonApplication.kt

Once the application starts, the API is available at `http://localhost:8080/api/v1/custommon`.

## API Endpoints

### Get All Custommons
**GET** `/api/v1/custommon`

Response:
```json
[
    {
        "id": 1,
        "name": "Kabutops",
        "description": "A shellfish Pokémon",
        "height": 1.3,
        "category": "Shellfish",
        "weight": 40.5,
        "passiveAbility": "Swift Swim",
        "availableSexes": ["MALE", "FEMALE"],
        "types": ["WATER", "ROCK"],
        "weaknesses": ["GRASS", "ELECTRIC", "FIGHTING", "GROUND"]
    }
]
```

### Get Custommon by ID
**GET** `/api/v1/custommon/{id}`

Example: `/api/v1/custommon/1`

Response:
```json
[
  {
    "id": 1,
    "name": "Kabutops",
    "description": " The cause behind the extinction of this species is unknown. Kabutops were aggressive Pokémon that inhabited warm seas.",
    "height": 1.3,
    "category": "Shellfish",
    "weight": 40.5,
    "passiveAbility": [
      "Battle Armor, Swift Swim"
    ],
    "availableSexes": [
      "MALE",
      "FEMALE"
    ],
    "types": [
      "ROCK",
      "WATER"
    ],
    "weaknesses": [
      "GRASS",
      "FIGHTING",
      "GROUND",
      "ELECTRIC"
    ]
  },
  {
    "id": 2,
    "name": "Bulbasaur",
    "description": "It carries a seed on its back right from birth. As its body grows larger, the seed does too.",
    "height": 0.7,
    "category": "Seed",
    "weight": 6.9,
    "passiveAbility": [
      "Overgrow"
    ],
    "availableSexes": [
      "MALE",
      "FEMALE"
    ],
    "types": [
      "GRASS",
      "POISON"
    ],
    "weaknesses": [
      "FIRE",
      "ICE",
      "FLYING",
      "PSYCHIC"
    ]
  }
]
```

### Create a New Custommon
**POST** `/api/v1/custommon`

Request Body:
```json
{
    "name": "Kabutops",
    "description": "A shellfish Pokémon",
    "height": 1.3,
    "category": "Shellfish",
    "weight": 40.5,
    "passiveAbility": "Swift Swim",
    "availableSexes": ["MALE", "FEMALE"],
    "types": ["WATER", "ROCK"]
}
```  

Response (201 Created):
```json
{
    "id": 2,
    "name": "Kabutops",
    "description": "A shellfish Pokémon",
    "height": 1.3,
    "category": "Shellfish",
    "weight": 40.5,
    "passiveAbility": "Swift Swim",
    "availableSexes": ["MALE", "FEMALE"],
    "types": ["WATER", "ROCK"],
    "weaknesses": ["GRASS", "ELECTRIC", "FIGHTING", "GROUND"]
}
```

### Delete a Custommon
**DELETE** `/api/v1/custommon/{id}`

Example: `/api/v1/custommon/2`

Response:
- `204 No Content` if successful
- `404 Not Found` if the ID does not exist

## Technologies Used
- Kotlin (Backend language)
- Spring Boot (Framework)
- Spring Data JPA (ORM)
- H2 Database (In-memory database for testing)
- Gradle (Build tool)
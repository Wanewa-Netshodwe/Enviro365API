# Enviro Assessment - Waste Management API

This project provides a RESTful API for managing waste categories, disposal guidelines, and recycling tips. The API is designed to promote proper waste management and recycling practices.

---

## Table of Contents
- [Features](#features)
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)
  - [Waste Category](#waste-category)
  - [Disposal Guidelines](#disposal-guidelines)
  - [Recycling Tips](#recycling-tips)
- [Contributing](#contributing)
- [License](#license)

---

## Features
- **Waste Category Management**: Create, retrieve, update, and delete waste categories.
- **Disposal Guidelines**: Create, retrieve, update, and delete waste disposal.
- **Recycling Tips**: Create, retrieve, update, and delete waste recycling tips.
- **Interactive API Documentation**: Explore and test the API endpoints using Swagger UI.

---


## API Documentation
### WasteCategory

![WasteCategory Controller](https://github.com/user-attachments/assets/99e7312a-18df-4e96-a732-cf13c5e15790)

#### create WasteCategory Request
```bash
Nb createdAt is Server Generated no need to input it
```
```json
{
  "id": "plastic1",
  "name": "Plastic Waste",
  "disposalGuidelines": {
    "id": "dg1",
    "instructions": [
      {
       "instruction": {"1": "Clean the plastic container before recycling."}
      },
      {"instruction": {"2": "Remove caps and lids to avoid contamination." }
      }
    ]
  },
  "recyclingTips": [
    {
      "id": "rt1",
      "tip": "Recycle responsibly by sorting plastics into the correct bin."
    },
    {
      "id": "rt2",
      "tip": "Ensure that plastics are free of food residues before recycling."
    },
    {
      "id": "rt3",
      "tip": "Avoid mixing plastics with non-recyclable materials."
    }
  ]
}

```
### DisposalGuideline
  ![dispoasal controller](https://github.com/user-attachments/assets/4d38bcb7-f5a7-4e26-bbbd-4d3bc54e4d68)
  #### create DispoalGuideline  Request
  ```json
{
    "wasteCategory_Id":"plastic1",
        "instructions": [
            {"instruction": {  "3": "Clean the plastic container before recycling."} }
        ]

}
```
### RecyclingTips
  ![Recycling tip png](https://github.com/user-attachments/assets/afb2d519-cbe8-4c9f-b4fd-953d0b1b8309)
  #### create RecyclingTip  Request
  ```json
{
    "wasteCategory_Id":"plastic1",
    "recyclingTips":[
        {
            "id": "rt7",
             "tip": "Recycle responsibly by sorting plastics into the correct bin."
        }
    ]
}
```
---

## API Endpoints Overview

| HTTP Method | Endpoint                                | Description                              | Authentication |
|-------------|----------------------------------------|------------------------------------------|----------------|
| `GET`       | `/wasteCategory/all`                   | Retrieve all waste categories.           | No             |
| `POST`      | `/wasteCategory/create`                | Add a new waste category.                | No             |
| `PUT`       | `/wasteCategory/update`                | Update an existing waste category.       | No             |
| `DELETE`    | `/wasteCategory/del/{id}`              | Delete a specific waste category by ID.  | No             |
| `GET`       | `/disposalGuidelines/all`              | Retrieve all disposal guidelines.        | No             |
| `POST`      | `/disposalGuidelines/create`           | Add a new disposal guideline.            | No             |
| `GET`       | `/swagger-ui/index.html`               | Access Swagger UI for API documentation. | No             |





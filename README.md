# Bowling-League-Score-Tracker


# 🎳 Bowling League Score Tracker
### *Enterprise Grade Logic & Analytics Engine*

A high-performance **Spring Boot** backend designed to manage competitive bowling leagues. This project moves beyond basic CRUD by implementing a complex non-linear scoring algorithm and real-time data aggregation for league standings.

---

## 🎯 The Core Challenge
Unlike a standard points-based game, bowling scoring is **recursive**. A strike or spare in Frame 1 depends on the values of the rolls in Frame 2. This project demonstrates:
* **Complex Business Logic:** Implementing the 10th-frame "bonus roll" mechanics.
* **Data Aggregation:** Transforming raw game logs into a professional leaderboard.

---

## 📊 League Standings Dashboard
The system programmatically calculates and returns the following analytics:

| Rank | Player | Wins | Top Score | Win% | Losses | Games Played |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **1** | John Doe | 15 | 289 | **75%** | 5 | 20 |
| **2** | Jane Smith | 12 | 245 | **60%** | 8 | 20 |

---

## 🛠️ Technical Implementation

### **Backend Architecture**
* **Spring Boot 3.x:** Core framework for RESTful API development.
* **Spring Data JPA:** Relational mapping between `Players`, `Teams`, and `Games`.
* **Hibernate Validator:** Ensures roll scores never exceed 10 pins per frame.

### **The "Logic Layer"**
* **Recursive Scoring Engine:** A Service layer that calculates frame scores by looking ahead at future `Roll` entities.
* **Aggregated Projections:** Utilizing JPQL to calculate `Win%` ($Wins / Games Played \times 100$) at the database level.
* **Transactional Integrity:** Using `@Transactional` to ensure a "Game" and its 10 "Frames" save as a single atomic unit.

---

## 🚀 Key API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/leaderboard` | Returns the ranked list of all players. |
| `POST` | `/api/v1/games` | Submits a new game (10 frames of data). |
| `GET` | `/api/v1/players/{id}` | Detailed breakdown of a player's career. |

---

## 🧪 Testing Focus
* **Unit Tests:** 100% coverage on the scoring algorithm (handling the "Perfect Game" case).
* **Integration Tests:** Verifying relational integrity when a Player is deleted.

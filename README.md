# 🏝️ Escape The Forgotten Island  

> **Genre:** Survival • Adventure  
> **Authors:** Huțanu Laurențiu & Loghin Elisei  
> **Group:** 1210B  

---

## 🌅 Story

After a devastating shipwreck caused by a violent storm, the protagonist wakes up stranded on a mysterious island.  
What appears to be a deserted paradise soon turns into a nightmare — filled with hostile creatures, ancient ruins, and perilous landscapes.  
Your mission: **collect keys, evade enemies, and escape the island alive.**

---

## 🎮 Gameplay Overview

🧭 **Objective:**  
- Find the **boat** to escape the island.  
- **Avoid enemies** and environmental hazards.  
- **Collect coins** for score and **keys** to unlock new levels.  

⌨️ **Controls:**  
| Action | Key |
|:--|:--|
| Move Up | ⬆️ |
| Move Down | ⬇️ |
| Move Left | ⬅️ |
| Move Right | ➡️ |
| Pause Menu | ⎋ Esc |

🧮 **Score Formula:**  
```
Score = Coins × 100 + Keys × 400 − Time_in_seconds
```

---

## 👤 Player

| Attribute | Value |
|:--|:--|
| Speed | 10 |

---

## 👾 Enemies

### 🪓 Orc  
- Moves randomly  
- Speed: 8  
- Appears in **Forest** & **Volcano**  
- 🗡️ Members of the *Goblin Clan*, hunting down all intruders.

---

### 🔥 Blaze  
- Moves on a predefined path  
- Speed: 8  
- Appears in **Volcano**  
- ⚡ Fiery spirits guarding ancient magma chambers — touch them, and you’re toast.

---

### 💀 Chupacabra  
- Predefined movement path  
- Detects the player within **5 tiles** (50% chance to chase)  
- Stops at **13 tiles**  
- Speed: 8  
- Appears in **Swamp**  
- Worshipped by **Swamp Orcs** as a bloodthirsty deity.

---

## 🌍 Levels

| Level | Environment | Obstacles | Enemies |
|:--|:--|:--|:--|
| **1. Forest** 🌲 | Trees & Rocks | Orcs | Home of the *Goblin Clan* |
| **2. Volcano** 🌋 | Lava Rivers | Orcs, Blaze | Realm of fiery spirits |
| **3. Swamp** 🐊 | Water Pools | Chupacabra, Swamp Orcs | Domain of a dark cult |

🎯 **Level Rules:**  
- 2 keys per level (only 1 needed to progress)  
- Collect coins for points  
- Bridge guard only opens passage if you have the key  
- Death resets the player to the **start of the current level**

---

## 🧩 Architecture & Design Patterns

**Implemented Patterns:**
| Pattern | Usage |
|:--|:--|
| 🧍‍♂️ Singleton | `Game`, `GameWindow`, `DatabaseManager`, `Music`, `Timer`, `SoundPlayer` |
| 🎭 Strategy | Enemy and player movement behaviors |
| 🔄 State | Game states (menu, play, pause, etc.) |
| 🏭 Factory Method | Creation of player and enemies |

---

## 💾 Database Integration

Two database systems ensure data persistence:  

| Database | Type | Purpose |
|:--|:--|:--|
| ☁️ Oracle Autonomous DB | Cloud | Online save/load system |
| 💽 SQLite | Local | Offline backup |

If no internet connection is detected, the game switches to **local mode** automatically.

**Main Tables:**
- `Players`: ID, Username, Password, Score  
- `Levels`: Position, Timer, Score, Completion State  
- `Coins`, `Map1–3`, `CollisionMap1–3`  

---

## 🔐 Login System

🧑‍💻 Features:
- **Sign Up:** Create a new account  
- **Log In:** Continue previous progress  
- **Error Handling:**  
  - Duplicate usernames  
  - Invalid credentials  

---

## ⚙️ Multithreading

When connecting to the database, the game uses a **SwingWorker thread** to perform background operations — preventing the UI from freezing during network delays.

---

## 🎵 Audio & Menus

- **Background music** and **sound effects** handled by Singleton classes (`Music`, `SoundPlayer`)  
- **Pause Menu:** Accessible via `ESC`, with options to *Resume*, *Settings*, or *Exit*

---

## 🧠 UML Diagrams

All UML diagrams are located in the `UMLs/` folder.  
They illustrate the relationships between major classes, states, and design patterns used throughout the project.

---

## 📚 Resources
- 🎨 [OpenGameArt.org](https://opengameart.org/) – Assets and sprites  
- 🧭 Concept inspired by *Escape! – Island Strategy RPG*

---

## 🧾 License
This project was developed for educational purposes as part of the **PAOO (Programare Avansată Orientată pe Obiecte)** course.

---

## 👥 Contributors
| Name | Role |
|:--|:--|
| **Huțanu Laurențiu** | Developer, Game Design |
| **Loghin Elisei** | Developer, Game Design |

---

💡 *"Every island hides a secret. Every survivor tells a story."*

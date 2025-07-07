# 🧪 Reqres API Tests

Автоматизированные тесты для публичного REST API [`reqres.in`](https://reqres.in/).  
Проект демонстрирует навыки API-тестирования, настройки CI/CD и интеграции с Telegram.

## 📌 Стек

- Java 17  
- Gradle  
- JUnit 5  
- REST-assured  
- GitHub Actions  
- Telegram Bot API  

## 🚀 Запуск тестов

Тесты запускаются вручную через GitHub Actions:

🔗 [Запустить тесты](https://github.com/kurtka1bane/reqresApi/actions/workflows/run-tests.yml)

## 📦 Отчёты

Результаты прогонов отправляются в Telegram.

📲 [Смотреть отчёты в Telegram](https://t.me/reqres_test_reports)

Пример отчёта:
📊 Результаты тестов
▫️ Всего тестов: 6
✅ Успешно: 4
❌ Упало: 2
▫️ Упавшие тесты:
▪️ GetUserTests.non-existent user returns 404
▪️ CreateUserTests.empty name returns 400


## ✅ Покрытие

Тестируются ключевые сценарии:
- GET /users
- GET /users/{id}
- POST /users
- Негативные кейсы (404, 400, ошибки валидации)

---

👤 Автор: [Роберт (kurtka1bane)](https://github.com/kurtka1bane)

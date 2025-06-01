using System;
using System.Collections.Generic;
using System.Linq;

class LibraryManager
{
    static List<string> availableBooks = new List<string>();
    static List<string> borrowedBooks = new List<string>();
    const int MaxLibraryBooks = 5;
    const int MaxBorrowedBooks = 3;

    static void Start()
    {
        while (true)
        {
            Console.WriteLine(@"
Choose an action:
add - Add a book
remove - Remove a book
search - Search for a book
borrow - Borrow a book
checkin - Check in a book
exit - Exit the program");

            string action = Console.ReadLine()?.Trim().ToLower();

            switch (action)
            {
                case "add":
                    AddBook();
                    break;
                case "remove":
                    RemoveBook();
                    break;
                case "search":
                    SearchBook();
                    break;
                case "borrow":
                    BorrowBook();
                    break;
                case "checkin":
                    CheckInBook();
                    break;
                case "exit":
                    return;
                default:
                    Console.WriteLine("Invalid action.");
                    break;
            }

            DisplayBooks();
        }
    }

    static void AddBook()
    {
        if (availableBooks.Count + borrowedBooks.Count >= MaxLibraryBooks)
        {
            Console.WriteLine("Library is at full capacity.");
            return;
        }

        Console.WriteLine("Enter the title of the book to add:");
        string newBook = Console.ReadLine()?.Trim();

        if (string.IsNullOrEmpty(newBook))
        {
            Console.WriteLine("Invalid title.");
            return;
        }

        availableBooks.Add(newBook);
        Console.WriteLine($"'{newBook}' added to the library.");
    }

    static void RemoveBook()
    {
        Console.WriteLine("Enter the title of the book to remove:");
        string title = Console.ReadLine()?.Trim();

        if (string.IsNullOrEmpty(title))
        {
            Console.WriteLine("Invalid title.");
            return;
        }

        int index = availableBooks.FindIndex(b => b.Equals(title, StringComparison.OrdinalIgnoreCase));

        if (index >= 0)
        {
            Console.WriteLine($"'{availableBooks[index]}' removed from the library.");
            availableBooks.RemoveAt(index);
        }
        else
        {
            Console.WriteLine("Book not found in available collection.");
        }
    }

    static void SearchBook()
    {
        Console.WriteLine("Enter the title to search:");
        string title = Console.ReadLine()?.Trim();

        if (string.IsNullOrEmpty(title))
        {
            Console.WriteLine("Invalid title.");
            return;
        }

        bool isAvailable = availableBooks.Any(b => b.Equals(title, StringComparison.OrdinalIgnoreCase));
        bool isBorrowed = borrowedBooks.Any(b => b.Equals(title, StringComparison.OrdinalIgnoreCase));

        if (isAvailable)
            Console.WriteLine("The book is available.");
        else if (isBorrowed)
            Console.WriteLine("The book is currently borrowed.");
        else
            Console.WriteLine("The book is not in the library.");
    }

    static void BorrowBook()
    {
        if (borrowedBooks.Count >= MaxBorrowedBooks)
        {
            Console.WriteLine("You have reached the maximum borrowing limit (3 books).");
            return;
        }

        Console.WriteLine("Enter the title of the book to borrow:");
        string? title = Console.ReadLine()?.Trim();

        if (string.IsNullOrEmpty(title))
        {
            Console.WriteLine("Invalid title.");
            return;
        }

        int index = availableBooks.FindIndex(b => b.Equals(title, StringComparison.OrdinalIgnoreCase));

        if (index >= 0)
        {
            borrowedBooks.Add(availableBooks[index]);
            availableBooks.RemoveAt(index);
            Console.WriteLine($"You borrowed '{title}'.");
        }
        else
        {
            Console.WriteLine("Book is not available for borrowing.");
        }
    }

    static void CheckInBook()
    {
        Console.WriteLine("Enter the title of the book to check in:");
        string title = Console.ReadLine()?.Trim();

        if (string.IsNullOrEmpty(title))
        {
            Console.WriteLine("Invalid title.");
            return;
        }

        int index = borrowedBooks.FindIndex(b => b.Equals(title, StringComparison.OrdinalIgnoreCase));

        if (index >= 0)
        {
            availableBooks.Add(borrowedBooks[index]);
            borrowedBooks.RemoveAt(index);
            Console.WriteLine($"'{title}' has been checked in.");
        }
        else
        {
            Console.WriteLine("That book is not currently borrowed.");
        }
    }

    static void DisplayBooks()
    {
        Console.WriteLine("\nAvailable Books:");
        if (availableBooks.Count == 0)
            Console.WriteLine("None");
        else
            availableBooks.ForEach(b => Console.WriteLine($"- {b}"));

        Console.WriteLine("\nBorrowed Books:");
        if (borrowedBooks.Count == 0)
            Console.WriteLine("None");
        else
            borrowedBooks.ForEach(b => Console.WriteLine($"- {b}"));

        Console.WriteLine();
    }
}

document.addEventListener('DOMContentLoaded', function() {
    // Setze das aktuelle Datum als Standardwert
    const today = new Date();
    const formattedDate = today.toISOString().substr(0, 10);
    document.getElementById('event-date').value = formattedDate;

    // Titel der Veranstaltung Dropdown-Logik
    const titleSelect = document.getElementById('event-title-select');
    const newTitleContainer = document.getElementById('new-title-container');
    const newTitleInput = document.getElementById('event-title');

    titleSelect.addEventListener('change', function() {
        if (this.value === 'new') {
            newTitleContainer.style.display = 'block';
            newTitleInput.focus();
        } else {
            newTitleContainer.style.display = 'none';
        }
    });

    // Number input controls
    const durationInput = document.getElementById('duration');
    const plusButton = document.querySelector('.plus');
    const minusButton = document.querySelector('.minus');

    plusButton.addEventListener('click', function() {
        durationInput.value = parseInt(durationInput.value) + 1;
    });

    minusButton.addEventListener('click', function() {
        if (parseInt(durationInput.value) > 0) {
            durationInput.value = parseInt(durationInput.value) - 1;
        }
    });

    // Sterne-Bewertung Funktionalität
    const stars = document.querySelectorAll('.star');
    let currentRating = 4; // Standard auf 4 Sterne setzen

    stars.forEach(star => {
        star.addEventListener('click', function() {
            const value = parseInt(this.getAttribute('data-value'));
            setRating(value);
        });

        star.addEventListener('mouseover', function() {
            const value = parseInt(this.getAttribute('data-value'));
            highlightStars(value);
        });

        star.addEventListener('mouseout', function() {
            highlightStars(currentRating);
        });
    });

    function setRating(value) {
        currentRating = value;
        highlightStars(value);
    }

    function highlightStars(count) {
        stars.forEach(star => {
            const starValue = parseInt(star.getAttribute('data-value'));
            if (starValue <= count) {
                star.classList.add('active');
            } else {
                star.classList.remove('active');
            }
        });
    }

    // Form submission
    const form = document.getElementById('eventForm');

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        // Ermittle den Veranstaltungstitel (entweder aus dem Dropdown oder dem neuen Titel)
        let eventTitle;
        if (titleSelect.value === 'new') {
            eventTitle = newTitleInput.value;
        } else {
            eventTitle = titleSelect.value;
        }

        // Collect form data
        const formData = {
            kukName: document.querySelector('.user-name').textContent,
            eventTitle: eventTitle,
            eventDate: document.getElementById('event-date').value,
            duration: document.getElementById('duration').value,
            provider: document.getElementById('provider').value,
            available: document.querySelector('input[name="available"]:checked')?.value,
            conference: document.querySelector('input[name="conference"]:checked')?.value,
            microtraining: document.querySelector('input[name="microtraining"]:checked')?.value,
            rating: currentRating
        };

        console.log('Form data:', formData);
        // Here you would typically send the data to a server

        alert('Formular erfolgreich gespeichert!');
    });

    // Cancel button
    const cancelButton = document.querySelector('.secondary');

    cancelButton.addEventListener('click', function() {
        if (confirm('Möchten Sie wirklich abbrechen? Alle nicht gespeicherten Änderungen gehen verloren.')) {
            form.reset();
            titleSelect.value = "";
            newTitleContainer.style.display = 'none';
            setRating(4); // Reset to default rating
            document.getElementById('event-date').value = formattedDate; // Reset date
        }
    });
});

function moveCarousel(direction) {
    const items = document.querySelectorAll('.itemCarrousel');
    items.forEach(item => {
        item.classList.add(direction === 'left' ? 'animate-left' : 'animate-right');
    });
    setTimeout(() => {
        items.forEach(item => {
            item.classList.remove('animate-left', 'animate-right');
        });
    }, 70); // tiempo de la animación en milisegundos
}

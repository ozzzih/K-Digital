import sys
import pygame

pygame.init()

screen = pygame.display.set_mode((1280,720))

clock = pygame.time.Clock()
image = pygame.image.load('./img/ship.bmp')
#rect=pygame.Rect(500,500,100,100)

#맨 밑 가운데 두기
image_rect = image.get_rect()
screen_rect = screen.get_rect() 
image_rect.midbottom=screen.get_rect().midbottom

def create_bullet(image_rect):
    bullet = pygame.Rect(0,0,5,10)
    bullet.midtop = image_rect.midtop
    bullet.top-=image_rect.height
    return bullet

bullets=[]
bullets.append(create_bullet(image_rect))


bullet_color = (255,0,0)
while True:
    # Process player inputs.
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                image_rect.left -= 10
            elif event.key == pygame.K_RIGHT:
                image_rect.left+=10
            elif event.key == pygame.K_UP:
                image_rect.top-=10
            elif event.key == pygame.K_DOWN:
                if image_rect.top+image_rect.height <= screen_rect.height:
                    image_rect.top+=10
            elif event.key == pygame.K_SPACE:
                bullets.append(create_bullet(image_rect))

    # Do logical updates here.
    new_bullets = []
    for bullet in bullets:
        if screen_rect.top<bullet.top:
            bullet.top-=1
            new_bullets.append(bullet)

    # ...

    screen.fill("purple")  # Fill the display with a solid color

    # Render the graphics here.
    # ...
    screen.blit(image, image_rect)
    for bullet in new_bullets:
        pygame.draw.rect(screen,bullet_color, bullet)
    pygame.display.flip()  # Refresh on-screen display
    clock.tick(60)         # wait until next frame (at 60 FPS)
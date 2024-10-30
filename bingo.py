
import pygame as pg
from abc import ABC, abstractmethod

"""
    Contains all of the state of the game; central reference point.
"""
class Game:
    self.entities = []
    self.projectiles = []

"""
    A person/being that is affected when it runs into a projectile and is
    drawn onto the screen every frame. Includes the Protagonist and Enemy
    classes.
"""
class Entity(ABC, pg.sprite.Sprite):
    @abstractmethod
    def hit(self, projectile):
        ...

"""
    Singleton class encapsulating the state of the player object: its
    position, items, orientation, health, and any other statuses.
"""
class Protagonist(Entity):
    def __init__(self, *groups):
        ...
    
    def update(self, *args, **kwargs):
        ...
    
    def hit(self, projectile):
        ...

"""
    An enemy, that shoots things *at* the player in order to damage it.
"""
class Enemy(Entity):
    def __init__(self, *groups):
        ...
    
    def update(self, *args, **kwargs):
        ...
    
    def hit(self, projectile):
        ...

"""
    Something moving, like a bullet or dart shot by the player or an enemy.
    Unlike the Entity superclass and its descendants, these will not
    take damage when they collide with other projectiles.
"""
class Projectile(pg.sprite.Sprite):
    def __init__(self, target_entities, friendly_entities, *groups):
        super().__init__(self, *groups)
        self.target_entities = target_entities
        self.friendly_entities = friendly_entities
        ...

    def is_targetting(self, entity):
        if self.target_entities:
            return entity in self.target_entities
        else:
            return entity not in self.friendly_entities
    
    def update(self, *args, **kwargs):
        for entity in Game.entities:
            if self.rect.colliderect(entity.rect) and self.is_targetting(entity):
                entity.hit(self)
        ... # and draw to screen etc

"""
    An item will be something that is used by the player for some advantage.
    These will sometimes be drawn to the screen before being picked up.
"""
class Item(pg.sprite.Sprite):
    ...
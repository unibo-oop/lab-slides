using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;

namespace Unibo.ISI.ProgramazioneAdOggetti.Esercitazioni
{
    abstract class Organism : IOrganism
    {
        protected IEnvironment environment;

        protected Organism(int width, int height)
        {
            Width = width;
            Height = height;
        }

        public void Initialize(IEnvironment environment)
        {
            // salva il riferimento all'interfaccia per usi futuri
            this.environment = environment;
        }

        public int Width { get; private set; }

        public int Height { get; private set; }

        public abstract Bitmap GetCurrentSprite(Direction direction);

        public abstract void UpdateBehaviour(ref Direction direction, ref int speed);
    }

    abstract class Vegetable : Organism
    {
        private Bitmap sprite;

        protected Vegetable(Bitmap sprite)
          : base(sprite.Width, sprite.Height)
        {
            this.sprite = sprite;
        }

        public override Bitmap GetCurrentSprite(Direction direction)
        {
            // un unico sprite che non dipende dalla direzione
            return sprite;
        }

        public override void UpdateBehaviour(ref Direction direction, ref int speed)
        {
            // è un vegetale: sta fermo
        }
    }

    abstract class Tree : Vegetable
    {
        private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\Trees.png", 64, 64);

        protected Tree(int spriteIndex)
          : base(spriteLoader[0, spriteIndex])
        {
        }
    }

    class FirTree : Tree
    {
        public FirTree()
          : base(0)
        {
        }
    }

    class PalmTree : Tree
    {
        public PalmTree()
          : base(1)
        {
        }
    }

    abstract class SmallPlant : Vegetable
    {
        private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\SmallPlants.png", 32, 32);

        protected SmallPlant(int spriteIndex)
          : base(spriteLoader[0, spriteIndex])
        {
        }
    }

    class Shrub : SmallPlant
    {
        public Shrub()
          : base(6)
        {
        }
    }

    abstract class Animal : Organism
    {
        private static SpriteLoader spriteLoader = new SpriteLoader(@"..\..\..\Images\Animals.png", 32, 48);

        private Bitmap sprite; // per ora considera un solo sprite, poi questo cambierà nella parte 4)

        protected Animal(int firstSpriteRow, int firstSpriteColumn)
          : base(spriteLoader.SpriteWidth, spriteLoader.SpriteHeight)
        {
            sprite = spriteLoader[firstSpriteRow, firstSpriteColumn];
        }

        public override Bitmap GetCurrentSprite(Direction direction)
        {
            return sprite;
        }

        public override void UpdateBehaviour(ref Direction direction, ref int speed)
        {
            // per ora resta fermo, poi questo cambierà nella parte 4)
        }
    }

    class Dog : Animal
    {
        public Dog()
          : base(0, 3)
        {
        }
    }

    class Cat : Animal
    {
        public Cat()
          : base(0, 6)
        {
        }
    }

    class Sheep : Animal
    {
        public Sheep()
          : base(4, 3)
        {
        }
    }

    class Goat : Animal
    {
        public Goat()
          : base(4, 0)
        {
        }
    }

    class Mouse : Animal
    {
        public Mouse()
          : base(0, 9)
        {
        }
    }
}

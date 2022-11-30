const App = {
  template:
    `<main>
    <section>
      <aside>
        <h4>🎲Trouver un cocktail au hasard</h4>
        <button @click="getRandomCocktail()">😮 Surprends-moi 😮</button>
      </aside>

      <aside>
        <h4>🍍Trouver un cocktail à base de :</h4>
        <select id="select1" v-model="ingredientResearch" >
        <option  value="choisirUnIngredient">
            Choisir un ingrédient
          </option>
          <option v-for="ingredient in allIngredients" :value=ingredient>
            {{ ingredient }}
          </option>
        </select>
        <button @click="getCocktailsByIngredient()">Rechercher</button>
      </aside>

      <aside>
      <h4>🔍Rechercher un cocktail</h4>
      <input v-model="inputResearch">
      <button @click="getCocktailsByName(this.inputResearch)">Rechercher</button>

      </aside>
    </section>
    <header style="paddingBottom: 0">
    <h3 v-if="cocktails.length == 1">1 Résultat</h3>
    <h3 v-if="cocktails.length > 1">{{ cocktails.length }} Résultats</h3>
    </header>

    <section>
      <aside v-for="cocktail in cocktails">
        <figure>
          <img :src= cocktail.strDrinkThumb>
        </figure>
        <h4>
          {{ cocktail.strDrink }}
          <sup>
            {{ cocktail.strAlcoholic }}
          </sup>
        </h4>
        <p>Type: {{ cocktail.strCategory }}</p>
        <p>Ingrédients:</p>
        <ul>
          <li v-for="ingredient in cocktail.strIngredients">
            {{ ingredient }}
          </li>
        </ul>
      </aside>
    </section>
    <article v-if="errorMessage != '' ">
    <aside>
      <p>{{ errorMessage }}</p>
    </aside>
  </article>
  </main>`,

  data() {
    return {
      cocktails: [],
      allIngredients: [],
      inputResearch: "",
      errorMessage: "",
      ingredientResearch: "choisirUnIngredient",
    };
  },
  mounted() {
    fetch('https://www.thecocktaildb.com/api/json/v1/1/list.php?i=list')
    .then((response)=>{
        response.json().then((data) =>{
          data.drinks.forEach( ingredient =>
            this.allIngredients.push(ingredient.strIngredient1))
        })
    })
  },
  methods: {
    getCocktailsByName(cocktailName){
      this.cocktails = [];
      this.errorMessage = "";
      if(cocktailName == ""){ 
        this.errorMessage = `Vous devez insérer le nom d'un cocktail`;
      }
      else{
        fetch(`https://www.thecocktaildb.com/api/json/v1/1/search.php?s=${cocktailName}`)
        .then(result => result.json())
        .then(result => {
          if(result.drinks == null){
            this.errorMessage = `Aucun cocktail existant au nom de " ${cocktailName} "`;
          }
          else{
            result.drinks.forEach(drink => {
              let strIngredients = this.getDrinkIngredients(drink);

              this.cocktails.push({
                strDrinkThumb: drink.strDrinkThumb,
                strDrink: drink.strDrink,
                strCategory: drink.strCategory,
                strAlcoholic: drink.strAlcoholic,
                strIngredients: strIngredients, 
              })
            })
          }
        });
      }

    },    
    getRandomCocktail() {
      this.cocktails = [];
      this.errorMessage = "";
      fetch('https://www.thecocktaildb.com/api/json/v1/1/random.php')
      // fetch('https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita')
        .then(result => result.json())
        .then(result => result.drinks.forEach(drink => {
          let strIngredients = this.getDrinkIngredients(drink);

          this.cocktails.push({
            strDrinkThumb: drink.strDrinkThumb,
            strDrink: drink.strDrink,
            strCategory: drink.strCategory,
            strAlcoholic: drink.strAlcoholic,
            strIngredients: strIngredients, 
          })
        })
        );
    },
    getCocktailsByIngredient(){
      this.cocktails = [];
      this.errorMessage = "";
      if(this.ingredientResearch == "" || this.ingredientResearch == "choisirUnIngredient"){ 
        this.errorMessage = `Vous devez choisir un ingrédient de cocktail`;
      }
      else{
        fetch(`https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=${this.ingredientResearch}`)
        .then(result => result.json())
        .then(result => {
          if(result.drinks == null){
            this.errorMessage = `Aucun cocktail existant au nom de " ${cocktailName} "`;
          }
          else{
            result.drinks.forEach(drinkOnlyId => {
              fetch(`https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=${drinkOnlyId.idDrink}`)
              .then(result => result.json())
              .then(result => {
                  result.drinks.forEach(drink => {
                    let strIngredients = this.getDrinkIngredients(drink);
      
                    this.cocktails.push({
                      strDrinkThumb: drink.strDrinkThumb,
                      strDrink: drink.strDrink,
                      strCategory: drink.strCategory,
                      strAlcoholic: drink.strAlcoholic,
                      strIngredients: strIngredients, 
                    })
                  })
              });
            })
          }
        })
      }
    },
    getDrinkIngredients(drink) {
      let ingredients = []
      if (drink.strIngredient1 != null) {
        ingredients.push(drink.strIngredient1);
      }
      if (drink.strIngredient2 != null) {
        ingredients.push(drink.strIngredient2);
      }
      if (drink.strIngredient3 != null) {
        ingredients.push(drink.strIngredient3);
      }
      if (drink.strIngredient4 != null) {
        ingredients.push(drink.strIngredient4);
      }
      if (drink.strIngredient5 != null) {
        ingredients.push(drink.strIngredient5);
      }
      if (drink.strIngredient6 != null) {
        ingredients.push(drink.strIngredient6);
      }
      if (drink.strIngredient7 != null) {
        ingredients.push(drink.strIngredient7);
      }
      if (drink.strIngredient8 != null) {
        ingredients.push(drink.strIngredient8);
      }
      if (drink.strIngredient9 != null) {
        ingredients.push(drink.strIngredient9);
      }
      if (drink.strIngredient11 != null) {
        ingredients.push(drink.strIngredient11);
      }
      if (drink.strIngredient12 != null) {
        ingredients.push(drink.strIngredient12);
      }
      if (drink.strIngredient13 != null) {
        ingredients.push(drink.strIngredient13);
      }
      if (drink.strIngredient14 != null) {
        ingredients.push(drink.strIngredient14);
      }
      if (drink.strIngredient15 != null) {
        ingredients.push(drink.strIngredient15);
      }
      return ingredients;
    },
    
  },
};

export default App;


<template>
    <div class="box">
        <div>
            <!-- <button @click="a = !a"> bla </button> -->
            <button @click="TogglePopup()"> 🔙 </button>
            <input type="text" id="titulo">
            <button @click="postNotes(), TogglePopup()">✔️</button>
        </div>

        <div class="campo" >
            <textarea name="texto" id="texto" cols="30" class="nota-space" rows="10"></textarea>
            <!-- <textarea name="nota" id="" cols="30" rows="10" class="nota-space"></textarea> -->
            <!-- <input type="text" id="texto" class=""> -->
        </div>

        <!-- <div class="campo">
            <h2>Prioridade: </h2>
            <select name="" id="prioridade">
                <option value="alta">2</option>
                <option value="media">1</option>
                <option value="baixa">0</option>
            </select>
        </div> -->
    </div>
</template>

<script>
    export default{
        props: ['TogglePopup'],
        name: 'Formulario',
        data() {
            return {
                show: false
            }
        },
        methods : {
            muda(){
                this.$router.push({ name: "home" })
            },
            postNotes(){
                fetch("http://localhost:8080/notes/nota", {
                    headers: {
                    'Accept': 'application/json',
                    'Content-Type' : 'application/json'
                    },
                    method: "POST",
                    body: JSON.stringify({
                    titulo: titulo.value,
                    nota: texto.value,
                    })
                })
                .then(response => response.text())
                .then(cad => {
                    this.muda();
                })
            },
        },
        beforeMount() {
            this.show = false
        }
    }
</script>

<style scoped>
template{
    overflow-y: hidden;
}
.box{
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 35px;
    margin-bottom: -1rem;
    margin-top: 75px;
    height: 45rem;
    background-color: #453e8688;
    /* background-color: rgb(84, 209, 0); */
    width: 100vw;
    animation-name: show;
    animation-duration: .5s;
}

button{
    font-size: 18px;
    border: none;
    background-color: transparent;
    color: #fff;
}

#titulo{
    color: #fff;
    margin-top: 1rem;
    margin-left: .5rem;
    width: 16rem;
    font-size: 34px;
    background-color: rgba(43, 51, 168, 0.61);
    border: none;
    border-radius: 12px;
}

#texto{
    color: #fff;
    background-color: rgba(43, 51, 168, 0.61);
    border: none;
    border-radius: 18px;
    font-size: 18px;
    margin-top: 1rem;
    width: 20rem;
    height: 37rem;
    margin-bottom: 18rem;
}

@keyframes show {
  from { margin-top: 1350px; }

  to { margin-bottom: -2rem; }
}
</style>
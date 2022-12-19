<template>
    <div class="box">
        <div class="campo">
            <h2>Titulo: </h2>
            <input type="text" id="titulo">
        </div>

        <div class="campo">
            <h2>Nota: </h2>
            <!-- <textarea name="nota" id="" cols="30" rows="10" class="nota-space"></textarea> -->
            <input type="text" id="texto" class="nota-space">
        </div>

        <div class="campo">
            <h2>Prioridade: </h2>
            <select name="" id="prioridade">
                <option value="alta">2</option>
                <option value="media">1</option>
                <option value="baixa">0</option>
            </select>
        </div>
    </div>
</template>

<script>
    export default{
        name: 'Formulario'
    }
</script>

<style scoped>
.box{
    /* display: flex;
    flex-direction: row; */
    /* flex-wrap: wrap; */
    width: 650px;
    height: 230px;
    background-color: aqua;
    border-radius: 25px;
    padding: 15px;
}
.campo {
    /* width: 50%; */
    justify-content: center;
    display: flex;
    flex-direction: row;
    height: 50px;
    background-color: chartreuse;
}
.nota-space{
    width: 450px;
}
#titulo{
    width: 300px;
}
</style>
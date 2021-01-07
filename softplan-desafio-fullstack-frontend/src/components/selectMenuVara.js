import React from 'react'

export default (props) => {

    const options = props.lista.map( (option, index)  => {
        return (
            <option key={index} value={option.id}>{option.descricaoVara}</option>
        )
    })

    return (
        <select {...props}  >
            {options}
        </select>
    )
}
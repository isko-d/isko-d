import { useFormContext } from "react-hook-form";

type Props = {
  fieldName: string,
  label?: string,
  inputProps?: Record<string, any>
  noLabel?: boolean
}

const FormGroup = ({ fieldName, label, inputProps, noLabel }: Props ) => {
  const { register } = useFormContext();

  return (
    <div className="flex flex-col mb-5 w-full">
      <label className={noLabel ? "hidden" : "block"} htmlFor={fieldName}>{label ?? fieldName}</label>
      <input className="bg-white w-full rounded-md p-1" {...register(fieldName)} placeholder={label ?? fieldName} {...inputProps} />
    </div>
  );
}

export default FormGroup;

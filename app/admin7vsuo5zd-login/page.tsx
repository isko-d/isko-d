"use client";

import FormGroup from "@/src/components/forms/FormGroup";
import Image from "next/image";
import { FormProvider, SubmitHandler, useForm } from "react-hook-form";

type Inputs = {
  email: string,
  password: string
}

const LoginPage = () => {
  const methods = useForm<Inputs>();

  const onSubmit: SubmitHandler<Inputs> = (data: Record<string, any>) => {
    console.log(data);
  }

  return (
    <div className="relative flex min-h-screen border-black font-sans">
      <Image className="object-cover" src="/assets/login.jpg" alt="Library" fill />
      <div className="bg-gray-300/50 backdrop-blur-lg z-10 ml-auto flex flex-col justify-center items-center p-8">
        <h1 className="text-3xl text-center">
          <strong>Isko'D</strong>: One ID, All Access
        </h1>
        <p className="text-center">
          <strong>PUP: University Library and Learning Resources Center</strong>
        </p>
        <FormProvider {...methods}>
          <form className="w-full mt-5" onSubmit={methods.handleSubmit(onSubmit)}>
            <FormGroup fieldName="email" label="Email" noLabel={true} />
            <FormGroup fieldName="password" label="Password" noLabel={true} />
            <button className="bg-red-900 text-center text-white p-2 rounded-md w-full cursor-pointer hover:bg-red-800 transition-colors">
              <strong>Submit</strong>
            </button>
          </form>
        </FormProvider>
      </div>
    </div>
  );
}

export default LoginPage;

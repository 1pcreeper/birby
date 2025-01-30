import ContainerProps from "./props/ContainerProps";

function Container({ children }: ContainerProps) {
    return (
        <>
            <div className="max-w-screen-2xl flex flex-wrap items-center justify-between mx-auto p-4">
                {children}
            </div>
        </>
    )
}
export default Container;